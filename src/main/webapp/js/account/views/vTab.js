
var VTabMenu = Marionette.ItemView.extend({

        //Le template de la navigation change, le template est donc défini dans le router directement

        initialize: function(myTemplate){
            this.$el.addClass('tabMenu');

        },

        selectMenu: function(menu) {
            $('ul.nav.nav-tabs a').parent().removeClass('active');
            $('ul.nav.nav-tabs a[href="#' + menu + '"]').parent().addClass('active');
        }
} );


var VTabSearch = Marionette.ItemView.extend({

    template : '#search-filter',
    tagName : 'form',

    initialize: function(options){
        this.$el.addClass('row-fluid littleMargeBot');
        console.log($('[name="result_filter"]'));
        console.log(this.options.inputURL);
       // debugger;
   },


    serializeData : function(){
//        Backbone.Model.prototype.toJSON.apply(this)
        //var data =    Backbone.Marionette.model.a
        //$('#block_filter').val(this.options.inputURL) ;
        //return this.model.attributes;
        //$('#block_filter').val(this.options.inputURL) ;
    },

    events:{
        'submit':'submit',
        'keyup':'change',

        'initialize:after' : 'refreshField'
    },

    refreshField : function(){
        $('[name="result_filter"]').val(this.options.inputURL) ;
    },

    change: function(e){
        var input = e.target.value;
        this.search(input);
    },

    submit: function(e){
        e.preventDefault();
        var input = $(e.target).find('[name="result_filter"]').val();
        this.search(input);
    },


    search: function(input){

        this.trigger('search', input);
        //ARTHUR GREG WHY?
        Backbone.history.navigate(this.options.urlHistory + input, {trigger: false});
        /*if(input != '') {
            this.collection.reset();
            this.collection.search(input);
        }*/
    }
    /*templateSearch: _.template($('#search-filter').html()),
    initialize: function(){
        this.$el.addClass('row-fluid');

        this.views = {};
        this.views.tab = new VTab({
            collection : this.collection,
            ViewModel : this.options.ViewModel,
            template: this.options.TabHeaderTemplate
        });
    }

});

var VTabContainer = Marionette.ItemView.extend({
   /* initialize: function(){
        this.$el.addClass('row-fluid');

        this.views = {};
        this.views.tab = new VTab({
            collection : this.collection,
            ViewModel : this.options.ViewModel,
            template: this.options.TabHeaderTemplate
        });
    },

    selectMenu: function(menu) {
        this.$el.find('ul.nav.nav-tabs a').parent().removeClass('active');
        this.$el.find('ul.nav.nav-tabs a[href="#' + menu + '"]').parent().addClass('active');
    },

    render: function(){
        this.$el.empty();
       // this.$el.append(this.options.MenuTemplate());
        this.$el.append(this.views.tab.render());
        this.delegateEvents();
        return this.$el;
    }*/
});

var VTab = Marionette.ItemView.extend({
   /* initialize: function() {
        this.$el.addClass('table');
        this.template = this.options.template;
        this.collection.bind('reset', this.render, this);
        this.collection.bind('add', this.addItem, this);
    },

    tagName: 'table',

    addItem: function(item) {
        this.$el.append(new this.options.ViewModel({
            model: item
        }).render());
    },

    render: function() {
        this.$el.empty();
        this.$el.append(this.template());
        this.collection.forEach(this.addItem, this);
        this.delegateEvents();
        return this.$el;
    }  */
});