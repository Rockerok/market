angular.module('my_market_front',[]).controller('appController',function ($scope,$http){
    const contPath = 'http://localhost:8189/market/api/v1/';
    let letPageIndex = 1;
    let letPageSize = 5;

    $scope.pageSize = function(){
        console.log(letPageSize);
//        console.log($scope.productsPage.);
    }

    $scope.loadAllProducts = function(letPageIndex,letPageSize){
//        letPageSize
        $http({
            url: contPath+'products',
            method:'GET',
            params: {
                p:letPageIndex,
                s:letPageSize
            }
        }).then(function(response){
                console.log(response);
                $scope.productsPage = response.data;
                $scope.paginationArray = $scope.generatePagesIndexes (1,$scope.productsPage.totalPages);
            });
            // при вызове через кнопку почему-то выдаёт ошибку
    }

    $scope.generatePagesIndexes = function (startPage, endPage){
        let arrayPage = [];
        for (let i=startPage; i<= endPage; i++){
            arrayPage.push(i);
        }
        return arrayPage;
    }


    $scope.deleteProduct = function (product){
        console.log(product.id);
        $http({
            url: contPath+'products/delete/',
            method: 'DELETE',
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
    if ($scope.productsPage.pageable.pageNumber>=0){
        letPageIndex=letPageIndex-1; }
        if (letPageIndex < 1) {
            letPageIndex = 1;
        }
        $scope.loadAllProducts(letPageIndex,letPageSize);
    }

    $scope.pageAfter = function(){
            if (letPageIndex > $scope.productsPage.totalPages) {
                letPageIndex = $scope.productsPage.totalPages;
            }
            letPageIndex=letPageIndex+1;
    $scope.loadAllProducts(letPageIndex,letPageSize);
    }

    $scope.showInfo = function (product) {
        alert(product.title);
    }

    $scope.loadAllProducts(letPageIndex,letPageSize);
});