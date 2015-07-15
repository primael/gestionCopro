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
		$('#search').html(new SearchView().render().el);
	},

	routes:{
		"" : "home",
	},

	home:function(){
		var coproprietaireList = new CoproprietaireCollection();
		coproprietaireList.fetch({
			success:function(){
				console.log("coproprietaire recuperer");
			}});
	},
});

utils.loadTemplate(['SearchView'], function() {
    app = new AppRouter();
    Backbone.history.start();
});