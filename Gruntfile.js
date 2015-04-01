// installing grunt command line
//		sudo npm install -g grunt-cli

// to add package.json, use 
//		npm init

// touch Gruntfile.js
// to run grunt, invoke grunt at command prompt, it will run the 'default' task

module.exports = function(grunt) {
	
	grunt.registerTask('task1', function() {
		console.log("Run task1");
	});

	grunt.registerTask('task2', function() {
		console.log("Run task2");
	});
	
	grunt.registerTask('default', ['task1', 'task2']);
	
	// TODO: copy angular.js from bower_components to webapp dir
};