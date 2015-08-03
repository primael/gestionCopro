window.ResultView = Backbone.View.extend({
    initialize: function () {
        this.render();
    },

    render: function () {
        //Liste des résultats
        $(this.el).append(this.template());
        //$('#resultList').html(.el);
    	new ListView({model:this.model});
        return this;
    },
});