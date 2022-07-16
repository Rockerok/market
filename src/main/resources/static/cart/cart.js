angular.module('my_market_front').controller('homeController',function ($scope,$http){
    const contPath = 'http://localhost:8189/market/api/v1/';
    const contPath = 'http://localhost:8189/market/api/v1/';
    let letPageIndex = 1;
    let letPageSize = 10;

    $scope.pageSize = function(){
        console.log(letPageSize);
        console.log($scope.product_page_size);
        letPageSize = $scope.product_page_size;
    }

    $scope.loadAllProductsCart = function(letPageIndex,letPageSize){
        currentPageIndex = letPageIndex;
        $http({
            url: contPath+'productsCart',
            method:'GET',
            params: {
                p:letPageIndex,
                s:letPageSize
            }
        }).then(function(response){
                console.log(response);
                $scope.productsPageCart = response.data;
                $scope.paginationArray = $scope.generatePagesIndexes (1,$scope.productsPageCart.totalPages);
            });
    }

    $scope.generatePagesIndexes = function (startPage, endPage){
        let arrayPage = [];
        for (let i=startPage; i<= endPage; i++){
            arrayPage.push(i);
        }
        return arrayPage;
    }

    $scope.pageBefore = function(){
    if ($scope.productsPageCart.pageable.pageNumber>=0){
        letPageIndex=letPageIndex-1; }
        if (letPageIndex < 1) {
            letPageIndex = 1;
        }
        $scope.loadAllProductsCart(letPageIndex,letPageSize);
    }

    $scope.pageAfter = function(){
        if (letPageIndex > $scope.productsPageCart.totalPages) {
            letPageIndex = $scope.productsPageCart.totalPages;
        }
        letPageIndex=letPageIndex+1;
        $scope.loadAllProductsCart(letPageIndex,letPageSize);
    }

    $scope.showProductInfo = function (product) {
        alert(product.title);
    }


    $scope.loadAllProductsCart(letPageIndex,letPageSize);

    $scope.cartAddProduct = function(product){
        $scope.cartAddProduct(product);
        alert(product.title + " added in Cart");
    }

    $scope.deleteCartProductById = function (product){
        console.log(product.id);
        $http({
            url: contPath+'cart/delete/',
            method: 'DELETE',
            params: {
               id: product.id
            }
        }).then(function(response){
                          console.log(response);
                          $scope.productsPageCart = response.data;
                      });
        //удаление идёт штатно, а вот страницу не обновляет
        $scope.loadAllProductsCart(letPageIndex,letPageSize);
    }

});