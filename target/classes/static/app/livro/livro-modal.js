'use strict';

app.module.controller('LivroModalController',[
  '$scope','$uibModalInstance','autorId','LivroService',
function ($scope, $uibModalInstance,autorId,LivroService) {

  console.log(autorId);
  LivroService.getAutorLivro(autorId)
  .success( function(data){
    $scope.autor=data;
    console.log($scope.autor);
  });


  $scope.ok = function () {
    $uibModalInstance.close($scope.autor);
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };

}]);
