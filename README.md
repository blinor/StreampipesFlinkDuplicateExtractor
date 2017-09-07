# StreampipesFlinkDuplicateExtractor
This modul can filter your Datastream based on a ID and a timestamp, optionale you can give a timewindow, where new Data will be ignored.

##Deployment:
You need to add this to your doocker-compose.yml:
  
            
	//
	dextractor:
	  image: laus.fzi.de:8201/weatherba/dextractor
	  depends_on:
	    - "consul"
	    - "jobmanager"
	    - "kafka"
	  ports:
	  networks:
	    - "8086:8086"
	  spnet:
