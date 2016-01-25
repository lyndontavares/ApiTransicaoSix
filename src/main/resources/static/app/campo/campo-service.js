'use strict';

app.module.factory('CampoService', [
'$http','SERVER_BASE',
function($http,SERVER_BASE) {

    var urlBase = SERVER_BASE + 'api/campo';

    var dataFactory = {};

    dataFactory.getCampos = function () {
        return $http.get(urlBase);
    };

    dataFactory.getCampo = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.insertCampo = function (merc) {
        return $http.post(urlBase, merc);
    };

    dataFactory.updateCampo = function (merc) {
        return $http.put(urlBase + '/' + merc.ID, merc)
    };

    dataFactory.deleteampo = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    dataFactory.getTabela = function (id) {
        return $http.get(urlBase + '/' + id + '/tabela');
    };

    dataFactory.insertListaCampos = function (tabelaOrigem) {
        return $http.post(urlBase + '/inserircampos/'+tabelaOrigem);
    };

    return dataFactory;

}]);
