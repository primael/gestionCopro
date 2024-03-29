define([
        'underscore',
        'backbone'
], function(_, Backbone){

	var Page = {
			el: null,
			current_view: null,
			
			_close_view: function(view){
				//view should not be present, if first view to appear
				if(!view) return;
				view.on_close();
			},
			
			_open_view: function(view){
				view.render();
			},
			
			//Transition form a old to new view
			show: function(view){
				var old_view = this.current_view;
				this.current_view = view;
				this._close_view(old_view);
				this._open_view(this.current_view);
			},
	};
	
	return Page;
	
});