const core = require('@actions/core');
const github = require('@actions/github');
const https = require('https');
const childProcess = require("child_process");


const _chromeVersion = core.getInput ('chrome-version');
const endpoint='https://storage.googleapis.com/chrome-for-testing-public';


function execute(command) {

    return new Promise(function(resolve, reject) {

      childProcess.exec(command,{maxBuffer: undefined}, function(error, standardOutput, standardError) {
        if (error) {
        console.log(error);
          reject();

          return;
        }

        if (standardError) {
          console.log(standardError);
          reject(standardError);

          return;
        }

        resolve(standardOutput);
      });
    });
  }

/********************************************************************************************************************/
function getJsonData(url) {
    return new Promise((resolve, reject) => {
        https.get(url, (response) => {
            let data = '';

            // A chunk of data has been received.
            response.on('data', (responseData) => {
                data += responseData;
            });

            // The whole response has been received.
            response.on('end', () => {
                try {
                    const jsonData = JSON.parse(data);
                    console.log(jsonData);
                    resolve(jsonData);
                } catch (error) {
                    reject(error);
                }
            });
        }).on('error', (error) => {
            console.error(error);
            reject(error);
        });
    });
}
/********************************************************************************************************************/
async function setupRunner() {

    const setupRunnerCommand = 'sudo apt-get install -y libnss3-dev libgdk-pixbuf2.0-dev libgtk-3-dev libxss-dev libgbm-dev gconf-service libasound2 libatk1.0-0 libc6 libcairo2 libcups2 libdbus-1-3 libexpat1 libfontconfig1 libgcc1 libgconf-2-4 libgdk-pixbuf2.0-0 libglib2.0-0 libgtk-3-0 libnspr4 libpango-1.0-0 libpangocairo-1.0-0 libstdc++6 libx11-6 libx11-xcb1 libxcb1 libxcomposite1 libxcursor1 libxdamage1 libxext6 libxfixes3 libxi6 libxrandr2 libxrender1 libxss1 libxtst6 ca-certificates fonts-liberation libnss3 lsb-release xdg-utils wget ca-certificates';

    try {
        await execute(setupRunnerCommand);
    } catch (error) {
        if (error instanceof Error) {
            throw new Error (error.message);
        } else {
            console.log(error);
        }
    };

}

/********************************************************************************************************************/

async function installChrome(chromeVersionInstalled){
    await setupRunner();
    let command='';
    command='sudo apt-get update && wget -N "'+endpoint+'/'+chromeVersionInstalled+'/linux64/chrome-linux64.zip" && sudo apt-get install unzip -q && sudo unzip -qq chrome-linux64.zip && sudo ln --symbolic "${PWD}/chrome-linux64/chrome" /usr/local/bin/chrome';

    try {
        console.log("Actual URL chrome: "+command)
        await execute(command);
    }
    catch (error) {
        if (error instanceof Error) {
            throw new Error (error.message);
          }
          else {
            console.log(error);
          }
    };

}

/********************************************************************************************************************/

async function installChromeDriver(chromeVersionInstalled){
    let command='';
    command='wget -P /temp/ "'+endpoint+'/'+chromeVersionInstalled+'/linux64/chromedriver-linux64.zip" --progress=dot:giga -O /tmp/chromedriver.zip && sudo rm -rf /opt/chromedriver && sudo mkdir -p /opt/chromedriver && sudo unzip -oj /tmp/chromedriver.zip -d /opt/chromedriver && sudo chmod +x /opt/chromedriver/chromedriver && rm /tmp/chromedriver.zip';

    try {
        console.log("Actual URL: "+command);
        await execute(command);
    }
    catch (error) {
        if (error instanceof Error) {
            throw new Error (error.message);
          }
          else {
            console.log(error);
          }
    };

}

/********************************************************************************************************************/


async function run() {
    let chromeVersionInstalled='';
    let jsonData='';
    const stableChromeVersionUrl="https://googlechromelabs.github.io/chrome-for-testing/last-known-good-versions.json";
    const lastestChromeVersionUrl="https://googlechromelabs.github.io/chrome-for-testing/latest-versions-per-milestone.json";
    if(!_chromeVersion){
         jsonData= await getJsonData(stableChromeVersionUrl);
        chromeVersionInstalled=jsonData.channels.Stable.version;
    }
    else{
        const pattern = /^\d+$/
        if(pattern.test(_chromeVersion)){
            jsonData=await getJsonData(lastestChromeVersionUrl);
            chromeVersionInstalled=jsonData.milestones[_chromeVersion].version

        }
        else{
            chromeVersionInstalled=_chromeVersion;
        }

    }
    console.log("Chrome version to be installed: " +chromeVersionInstalled);
    await installChrome(chromeVersionInstalled);
    //await installChromeDriver(chromeVersionInstalled);
    console.log("Chrome version installed: " +await execute("chrome -version"));


}
run();
