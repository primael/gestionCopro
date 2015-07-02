var React = require('react');
//var ProductData = require('./ProductData');
//var CartAPI = require('./utils/CartAPI')
//var FluxCartApp = require('./components/FluxCartApp.react');
var GestCopSearch = require('./components/search/GestCopSearch.react');

// Load Mock Product Data into localStorage
//ProductData.init();

// Load Mock API Call
//CartAPI.getProductData();

// Render FluxCartApp Controller View
React.render(
  <GestCopSearch />,
  document.getElementById('flux-search')
);