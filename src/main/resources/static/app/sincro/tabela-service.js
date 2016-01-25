'use strict';

app.module.factory('TabelaService', [
'$http','SERVER_BASE',
function($http,SERVER_BASE) {

    //expect(MOVIE_TITLE).toEqual('http://localhost:5000/');SERVER_BASE

    //var urlBase = 'json/tab.json'; //SERVER_BASE
    var urlBase = SERVER_BASE + 'api/tabela';//'json/tab.json'; //SERVER_BASE

    var dataFactory = {};

    dataFactory.getTabelas = function () {
        return $http.get(urlBase);
    };

    dataFactory.getTabela = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.insertTabela = function (merc) {
        return $http.post(urlBase, merc);
    };

    dataFactory.updateTabela = function (merc) {
        return $http.put(urlBase + '/' + merc.ID, merc)
    };

    dataFactory.deleteTabela = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    dataFactory.getCampos = function (id) {
        return $http.get(urlBase + '/tabela/' + id + '/campo');
    };

    dataFactory.sincronizarAll = function () {
        return $http.post(SERVER_BASE + 'api/sincronizar/all');
    };

    dataFactory.sincronizarSincronizaveis = function () {
        return $http.post(SERVER_BASE + 'api/sincronizar/sincronizaveis');
    };


    return dataFactory;
}]);
