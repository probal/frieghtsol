## Development
```
$ git clone git@github.com:jackhutu/jackblog-vue.git
$ cd jackblog-vue
$ npm install
$ npm run dev
```
Open http: // localhost: 3000 automatically in the browser

## Debugging
The default open vue-devtools [chrome browser extension](https://github.com/vuejs/vue-devtools) , the production environment automatically shut down

### Directory Structure

```
.
├── README.md           
├── dist                     // Project build directory
├── logs                     // Production environment log directory
├── src                      // Production catalog
│   ├── api                  // API request
│   ├── assets               // css and picture resources
│   ├── components           // Component
│   ├── utils                // Tool function
│   └── store                // vuex related files, store,action
│   └── config.js            // api url, cookie domain and other configuration files
│   └── index.html           // Homepage html
│   └── routes.js            // Routing configuration
│   └── index.js             // Entry file
├── .babelrc                 // babel configuration
├── .eslintrc.json           // eslint configuration
├── server.js                // The production environment starts the server
├── webpack.config.js        // Webpack configuration file
```

## Production environment construction
```
$ npm run build
```
