var express=require('express');
var mysql=require('mysql');
var fs=require('fs');

var app=express();

var connection=mysql.createConnection({
	host : "51.254.132.239",
	user : "root",
	password : "admin",
	charset : "utf8"
});

connection.query('USE rated_app');


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

app.use('/',function(req,res){
	readJSONFile('data/movies.json',function(err,data){
		var data=data.movies;
		for(var i=0;i<data.length;i++){
			var info={
				description: data[i].description,
				rate:1,
				year:data[i].year,
				name:data[i].title,
				type:data[i].tags
			};
			var k=0;
			connection.query('INSERT INTO Movie SET ?', info, function(err, result) {
  				console.log(k+" "+err);
  				k++;
  			});
		}
	});
});

app.listen(3000,function(){
	console.log('Started !');
});