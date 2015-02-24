'use strict';

WirgeManageApp.controller('UserMessagesController', ['$scope', '$route', 'UserMessageService', 'resolvedMessages',

  function ($scope, $route, userMessageService, resolvedMessages) {

    $scope.userMessages = resolvedMessages;

    resolvedMessages.$promise.then(function (resolvedMessages) {
      console.log($scope.userMessages.length + " messages");
    });


  }]);
