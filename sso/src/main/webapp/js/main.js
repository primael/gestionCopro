$.ajaxSetup({
	statusCode : {
		401 : function() {
			window.location.replace('#login');
		},
		403 : function() {
			window.location.replace('#denied');
		}
	}

});

Backbone.View.prototype.close = function() {
	console.log('Closing view ' + this);
	if (this.beforeClose) {
		this.beforeClose();
	}
	this.remove();
	this.unbind();
};

var AppRouter = Backbone.Router.extend({

	initialize : function() {
		//$('#content').html(new LoginView().render().el);
	},

	routes : {
		"home" : "home",
		"" : "login"
	},

	home : function() {
		this.headerView = new HeaderView();
		$('.header').html(this.headerView.render().el);
		$('#content').html('');
	},

	login : function() {
		$('#content').html(new LoginView().render().el);
	}
});

utils.loadTemplate([ 'LoginView', 'HeaderView' ], function() {
	app = new AppRouter();
	Backbone.history.start();
});