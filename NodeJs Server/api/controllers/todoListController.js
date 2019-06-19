'use strict';
const https = require('https');

exports.list_all_tasks = function(req, res) {

  let url = 'https://api.fda.gov/drug/event.json?search=patient.reaction.reactionmeddrapt.exact:'+req.params.reaction+'&count=patient.drug.activesubstance.activesubstancename.exact';
    https.get(url, (resp) => {
      let data = '';
    
      resp.on('data', (chunk) => {
        data += chunk;
      });
    
      // The whole response has been received. Print out the result.
      resp.on('end', () => {
        let result = JSON.parse(data);
        var JSONItems = [];
        JSONItems = result.results.sort(function(a, b) {
          return b.count - a.count;
      });
        res.json(JSONItems.slice(0, 10));
      });
    
    }).on("error", (err) => {
      console.log("Error: " + err.message);
    });
};




