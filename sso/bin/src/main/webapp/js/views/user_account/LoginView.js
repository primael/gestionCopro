define([ 'jquery', 'underscore', 'backbone', 'models/Session',
		'text!templates/user_account/login.html', 'jqueryui', 'validation' ], function($, _, Backbone,
		Session, view_template) {

	var CollectionView = Backbone.View.extend({
		container_id : 'login',

		initialize : function() {

		},

		render : function() {
			var template_options = {
				'container_id' : this.container_id
			};
			this.template = _.template(view_template, template_options);
			var new_view = this.$el.append(this.template);
			// add the collection to the view.
			return new_view;
		},
		
		events: {
	        "click .connexion"   : "click_submit"
	    },
	    
	    click_submit: function(event){
	    	var form = $('#signin');
	    	var that = this;
	    	
	    	form.validate({
	    		//rules are a dictionnary of the inpuname to it's rules.
	    		rules: {
	    			username:{
	    				required: true
	    			},
	    			password:{
	    				required: true
	    			}
	    		},
	    		
	    		highlight: function(element){
	    			$(element).closest('.control-group').addClass('has-error has-feedback');
	    			$(element).after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>')
	    		},
	    		//remove the error
	    		unhighlight: function(element){
	    			$(element).closest('.control-group').removeClass('has-error has-feedback');
	    			$(element).next().remove();
	    		},
	    		errorElement: 'span',
	    		errorClass: 'help-inline',
	    		errorPlacement: function(error, element){
	    			//error.insertAfter(element);
	    		},
	    		//if the form is valid, then create a new question
	    		submitHandler: function(form){
	    			that.login(form);
	    		}
	    	})
	    },
	    
	    login: function(form){
	    	var user_login_form = $(form).serializeArray();
	    	var new_user_params = {};
	    	for(var i = 0; i < user_login_form.length; i++){
	    		var user_param = user_login_form[i];
	    		new_user_params[user_param.name] = user_param.value;
	    	}
	    	
	    	Session.login(new_user_params, this.update_msg);
	    },
	    
	    update_msg: function() {
	          var error_msg = $('#login-error');
	          error_msg.html('Bad credential');
	      }

	});
	
	return CollectionView;
});
