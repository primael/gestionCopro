Backbone.View.prototype.close = function() {
	console.log('Closing view ' + this);
	if(this.beforeClose){
		this.beforeClose();
	}
	this.remove();
	this.unbind();
};

var AppRouter = Backbone.Router.extend({

	initialize: function(){
		$('#content').html(new LoginView().render().el);		
	},

	routes:{
		
	},
});

utils.loadTemplate(['LoginView'], function() {
    app = new AppRouter();
    Backbone.history.start();
});