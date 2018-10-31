var app = angular.module('app', ['ui.grid', 'ui.grid.pagination']);

app.controller('TestStudentCtrl', ['$scope', 'TestStudentService', function ($scope, TestStudentService) {
    var paginationOptions = {
        pageNumber: 1,
        pageSize: 5,
        sort: null
    };

    TestStudentService.getTestStudents(paginationOptions.pageNumber,
        paginationOptions.pageSize).success(function (data) {
            $scope.gridOptions.data = data.content;
            $scope.gridOptions.totalItems = data.totalItems;
        }
    );

    $scope.gridOptions = {
        paginationPageSizes: [5,10,20],
        paginationPageSize: paginationOptions.pageSize,
        enableColumnMenus:false,
        useExternalPagination: true,
        columnDefs:[
            {name: 'id'},
            {name: 'name'},
            {name: 'gender'},
            {name: 'age'}
        ],
        onRegisterApi:function (gridApi) {
            $scope.gridApi = gridApi;
            gridApi.pagination.on.paginationChanged($scope,function (newPage,pageSize) {
                paginationOptions.pageNumber = newPage;
                paginationOptions.pageSize = pageSize;

                TestStudentService.getTestStudents(newPage,pageSize).success(function (data) {
                    $scope.gridOptions.data = data.content;
                    $scope.gridOptions.totalItems = data.totalItems;
                });
            });
        }
    };

}]);

app.service('TestStudentService', ['$http', function ($http) {
        function getTestStudents(pageNumber, size) {
            pageNumber = pageNumber > 0 ? pageNumber - 1 : 0;
            return $http({
                method: 'GET',
                url: 'teststudent/get?page=' + pageNumber + '&size=' + size
            });
        }

        return {
            getTestStudents: getTestStudents
        }
    }]
);