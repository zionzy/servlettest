// installing grunt command line
//		sudo npm install -g grunt-cli

// to add package.json, use 
//		npm init

// touch Gruntfile.js
// to run grunt, invoke grunt at command prompt, it will run the 'default' task

module.exports = function(grunt) {

	grunt.initConfig({
		karma: {
	 //      	options: {
	 //        	// point all tasks to karma config file
	 //        	configFile: 'test/karma-conf.js'
	 //      	},
	 //      	unit: {
	 //        	// run tests once instead of continuously
	 //        	singleRun: true
	 //      	},
	 //      	continuous: {
	 //      		// keep karma running in the background
	 //      		background: true
	 //      	}
	    	unit: {
	    		options: {
	    			files: ['src/test/**/*.js']
	    		}
	    	}
	    },
	    // grunt jasmine
	    jasmine: {
	    	// project source files
	    	src: ['src/main/webapp/javascript/**/*.js'],
	    	options: {
		    	vendor: ['src/main/webapp/lib/angular/angular.js','src/main/webapp/lib/angular-mocks/angular-mocks.js'],
		    	// jasmine spec files
		    	specs: ['src/test/js/myControllerUnitTest.js'],
		    	// spec helper files
		    	helpers: ['']	    		
	    	}
	    },
	    watch: {
	    	karma: {
	    		files: ['test/js/*.js'],
	    		// run these tasks when these files change
	    		tasks: ['karma:continuous:run'] // note the :run flag
	    	},
	    	jsfiles: {
	    		files: ['src/main/webapp/javascript/*.js'],
	    		tasks: ['copy:dev']
	    	}
	    },
	    copy: {
	    	main: {
	    		files: [
	    			{expand: true, cwd: 'bower_components/', src: ['angular/*.js'], dest: 'src/main/webapp/lib/', filter: 'isFile'},
	    			{expand: true, cwd: 'bower_components/', src: ['angular-mocks/*.js'], dest: 'src/main/webapp/lib/', filter: 'isFile'}
	    		]
	    	},
	    	dev: {
	    		files: [
	    			{expand: false, src: ['src/main/webapp/javascript/*.js'], dest: 'src/main/jsFiles/'}
	    		]
	    	}
	    },
	    less: {
	    	development: {
		    	options: {
		    		paths: ["less/"]
		    	},
		    	files: {
		    		"src/main/webapp/css/servlettest.css": "src/main/webapp/less/servlettest.less"
		    	}	    		
	    	}
	    }
    });
	
	grunt.registerTask('task1', function() {
		console.log("Run task1");
	});

	grunt.registerTask('task2', function() {
		console.log("Run task2");
	});
	
	grunt.registerTask('default', ['task1', 'task2']);
	
	// TODO: copy angular.js from bower_components to webapp dir
	
	grunt.loadNpmTasks('grunt-contrib-copy');
	grunt.loadNpmTasks('grunt-contrib-watch');

	// load the Grunt task
  	grunt.loadNpmTasks('grunt-karma');
  	// run task as grunt jasmine
  	grunt.loadNpmTasks('grunt-contrib-jasmine');
  	//
  	grunt.loadNpmTasks('grunt-contrib-less');

  	grunt.registerTask('unit-test', ['karma:continuous:start', 'watch:karma']);
};