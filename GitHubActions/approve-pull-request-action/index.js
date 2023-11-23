const core = require('@actions/core');
const github = require('@actions/github');

const main = async () => {
  const token = core.getInput('github-token')
  const number = core.getInput('pr-number')
  const { owner, repo } = github.context.repo;
  const octokit = github.getOctokit(token)

  await octokit.rest.pulls.createReview({
      owner: owner,
      repo: repo,
      pull_number: number,
      body: "This PR is auto approved by github action",
      event: 'APPROVE'
    })
}
main().catch(err => core.setFailed(err.message))
