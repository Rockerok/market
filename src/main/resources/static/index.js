(function () {
    angular
        .module('my_market_front', ['ngRoute'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl:'home/home.html',
                controller: 'homeController'
            })
            .when('/store', {
                templateUrl: 'store/store.html',
                controller: 'storeController'
            })
            .when('/edit_product/:productId', {
                templateUrl: 'edit_product/edit_product.html',
                controller: 'editProductController'
            })
            .when('/create_product', {
                templateUrl: 'create_product/create_product.html',
                controller: 'createProductController'
            })
            .when('/card',{
                templateUrl:'card/card.html',
                controller: 'cardController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http) {
    }
})();

angular.module('my_market_front').controller('indexController', function ($rootScope, $scope, $http) {
    const contextPath = 'http://localhost:8189/market/api/v1';
});