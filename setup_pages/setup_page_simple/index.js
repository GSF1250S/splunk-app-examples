const browserify = require("browserify");
const fs = require("fs");
const outputDirectory = './appserver/static/javascript';

if (!fs.existsSync(outputDirectory)){
    fs.mkdirSync(outputDirectory, { recursive: true });
}
browserify("./src/setup_page.js")
  .transform("babelify", {
    presets: [
      "@babel/preset-env"
    ],
  })
  .bundle()
  .pipe(fs.createWriteStream(outputDirectory + "/app.js"));