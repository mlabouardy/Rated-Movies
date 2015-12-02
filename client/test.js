
app.use('/',function(req,res){
	/*readJSONFile('data/upcoming.json',function(err,data){
		var data=data.movies;
		for(var i=0;i<data.length;i++){
			var info={
				img: data[i].img,
				description: data[i].description,
				rate:data[i].rating,
				year:data[i].year,
				name:data[i].title,
				type:data[i].tags
			};
			
			var k=0;
		client.create({
	        index: 'movies',
	        type: 'upcoming',
	        body: {
	            info
	        }
	        }, function (error, response) {
	        	console.log(k);
	        	k++;
	            console.log(error+" "+response);
        });


		}
	});*/

/*	client.search({
	  index: 'movies',
	  type: 'popular',
	  size:200
	}, function (error, response) {
	   console.log(response.hits.hits._source);
	});*/
});
