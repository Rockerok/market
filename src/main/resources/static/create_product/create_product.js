angular.module('my_market_front').controller('createProductController',function ($scope,$http,$routeParams, $location){
    const contPath = 'http://localhost:8189/market/api/v1/';

    $scope.createNewProduct = function () {
        if ($scope.new_product == null) {
            alert("Форма не заполнена");
            return;
        }
        $http.post(contextPath + '/products', $scope.new_product)
            .then(function successCallback(response) {
                    $scope.new_product = null;
                    alert("Продукт успешно создан");
                    $location.path('/store');
                }, function failCallback(response) {
                    alert(response.data.messages);
                }
            );
    }

});