angular.module('my_market_front',[]).controller('appController',function ($scope,$http){
    const contPath = 'http://localhost:8189/market/';
    let letPageIndex = 1;
    let letPageSize = 5;

    $scope.pageSize = function(){
        console.log(letPageSize);
        console.log();
    }

    $scope.loadAllProducts = function(letPageIndex,letPageSize){
        letPageSize =
        $http({
            url: contPath+'products',
            method:'GET',
            params: {
                page:letPageIndex,
                size:letPageSize
            }
        }).then(function(response){
                console.log(response);
                $scope.productsPage = response.data;
            });
            // при вызове через кнопку почему-то выдаёт ошибку
    }

    $scope.deleteProduct = function (product){
        console.log(product.id);
        $http({
            url: contPath+'products/delete',
            method: 'GET',
            params: {
               id: product.id
            }
        }).then(function(response){
                          console.log(response);
                          $scope.productsPage = response.data;
                      });
        //удаление идёт штатно, а вот страницу не обновляет
        $scope.loadAllProducts(letPageIndex,letPageSize);
    }

        $scope.pageBefore = function(){
        if ($scope.productsPage.pageable.pageNumber>=0)
                {  letPageIndex=letPageIndex-1; }
        $scope.loadAllProducts(letPageIndex,letPageSize);
        }

        $scope.pageAfter = function(){
                letPageIndex=letPageIndex+1;
        $scope.loadAllProducts(letPageIndex,letPageSize);
        }

        $scope.loadAllProducts(letPageIndex,letPageSize);
//        console.log (scope.productsPage.pageable.pageNumber);
});