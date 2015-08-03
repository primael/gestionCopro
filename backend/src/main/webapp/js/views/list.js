window.ListView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
    	
        this.model.each(function(item){
        	if(item.get('type')=="coproprietaire"){
        		$('#resultList', this.el).append(new CoproprietaireListItemView({model: item}).render().el);
        	}
        });
        
        return this;
    }
});

window.CoproprietaireListItemView = Backbone.View.extend({

	render: function() {
		$(this.el).append(this.template(this.model.toJSON()));
		return this;
	}
});
