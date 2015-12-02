var express=require('express');
var fs=require('fs');
var elasticsearch=require('elasticsearch');

var app=express();



function readJSONFile(filename, callback) {
  fs.readFile(filename, function (err, data) {
    if(err) {
      callback(err);
      return;
    }
    try {
      callback(null, JSON.parse(data));
    } catch(exception) {
      callback(exception);
    }
  });
}

var client=elasticsearch.Client({
  host: "51.254.132.239:9200",
  requestTimeout: 900000, maxSockets: 20
});

console.log("ok");

app.use('/movies/:name',function(req,res){
	console.log(req.params.name);
	client.search({
	  index: 'movies',
	  type: req.params.name,
	  size: 20
	}, function (error, response) {
		var data=response.hits.hits;
		var movies=[];
		for(var i=0;i<data.length;i++)
			movies.push(data[i]._source.info);
	   	res.send(movies);

	});
});

app.listen(3000,function(){
	console.log('Started !');
});