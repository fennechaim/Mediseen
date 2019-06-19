'use strict';

module.exports = function(app) {
	var todoList = require('../controllers/todoListController');

	// todoList Routes
	app.route('/tasks/:reaction')
		.get(todoList.list_all_tasks)
	
		
};
