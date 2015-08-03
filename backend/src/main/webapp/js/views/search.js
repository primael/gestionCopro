window.SearchView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template());
        return this;
    },

    events: {
        "click .search"   : "beforeSearch",
        "click .allSearch" : "changeItemAll",
        "click .userSearch" : "changeItemUser",
        "click .buildingSearch" : "changeItemBuilding",
    },

    selectMenuItem: function (menuItem) {
        $('.nav li').removeClass('active');
        if (menuItem) {
            $('.' + menuItem).addClass('active');
        }
    },

    beforeSearch: function () {
        //On lance la recherche non?
        this.search();
        return true;
    },

    search: function () {        
        //En fonction de la zone les éléments de recherche sont différents:
        if($('#zoneSearch').attr("data-zone")==='USER'){
            var coproprietaireList = new CoproprietaireSearchCollection([],{term: $('#textSearch').val()});
            coproprietaireList.fetch({
                success:function(collection){

                    //On doit modifier le conteneur pour lui mettre la vue 
                    //des résultats des copropriétaires
                    $('#conteneur').html(new ResultView({model:collection}).el);
                    new ResultView({model:collection});
                }
            });
        }
        //console.log('élément recherché : ' + $('#textSearch').val() + ' zone de recherche : ' + $('#zoneSearch').attr("data-zone"));
        
    },

    changeItemAll: function(){
        console.log('élément recherché : ' + $('#textSearch').val() + ' zone de recherche : ' + $('#zoneSearch').attr("data-zone"));
        $('#zoneSearch').removeClass().addClass('glyphicon glyphicon-menu-hamburger').attr('data-zone','ALL');
    },

    changeItemUser: function(){
        console.log('élément recherché : ' + $('#textSearch').val() + ' zone de recherche : ' + $('#zoneSearch').attr("data-zone"));
        $('#zoneSearch').removeClass().addClass('glyphicon glyphicon-user').attr('data-zone','USER');
    },

    changeItemBuilding: function(){
        console.log('élément recherché : ' + $('#textSearch').val() + ' zone de recherche : ' + $('#zoneSearch').attr("data-zone"));
        $('#zoneSearch').removeClass().addClass('glyphicon glyphicon-stats').attr('data-zone','BUILDING');
    },
});