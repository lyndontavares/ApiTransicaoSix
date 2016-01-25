angular.module('angularMaskMoneyDemo', ['maskMoney'])
.run(['$rootScope', function($scope) {

      $scope.myInput1 = 1;    
      $scope.myInput2 = 1;    
      $scope.myInput3 = 1;    
      $scope.myInput4 = 1;    

    $scope.setValue = function(){
    }; 
    
    $scope.options1 = {
            prefix: 'R$  ',
            thousands:'.', 
            decimal:',',
            precision:4
        }
    $scope.options2 = {
            prefix: 'G$  ',
            thousands:'.', 
            decimal:',',
            precision:0
        }
    $scope.options3 = {
            prefix: 'US$  ',
            thousands:'.', 
            decimal:',',
            precision:2
        }
    $scope.options4 = {
            prefix: 'E$  ',
            thousands:'.', 
            decimal:',',
            precision:6
        }



}
]);