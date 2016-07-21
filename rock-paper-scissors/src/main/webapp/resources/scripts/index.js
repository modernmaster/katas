/// <reference path="lib/jquery-1.7.1.min.js" />

Index = {
	setup: function() {
		Index.setupEventHandlers();
		Index.populateGestures();
	},

	setupEventHandlers : function() {
	$(Index.Ids.PlayGame).click(Index.postGame);
	$(Index.Ids.Player1).change(Index.addPlayer1StatusHandler);
	},	
	
	addPlayer1StatusHandler:function() {
		if ($(this).val() === "human") {
			$(Index.Ids.Player1Gesture).show();
		} else {
			$(Index.Ids.Player1Gesture).hide();			
		}		
	},		
	
	populateGestures : function() {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType: 'json',
			url : 'gesture/',
			success : Index.renderGestures,
			error : Index.failedAtPlayingGame
		});
	},
	
	postGame : function() {
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : 'game/',
			dataType: 'json',
			data : Index.formToJSON(),
			success : Index.successAtPlayingGame,
			error : Index.failedAtPlayingGame
		});
	},
	
	successAtPlayingGame:function(data) {
		$(Index.Ids.ErrorMessage).hide();
		$(Index.Ids.WinningPlayer).text(data.winner);
		$(Index.Ids.WinningCondition).text(data.result);
		$(Index.Ids.WinningPlayer).show();
		$(Index.Ids.WinningCondition).show();
		$(Index.Ids.Outcome).show();
	},
	
	failedAtPlayingGame:function(jqXHR, textStatus, errorThrown)  {
		$(Index.Ids.WinningPlayer).hide();
		$(Index.Ids.WinningCondition).hide();
		$(Index.Ids.ErrorMessage).text('Opps, there has been a problem ' + errorThrown);
	},
	
	renderGestures:function(data)  {
		var list = data == null ? [] : (data instanceof Array ? data : [ data ]);
		var $subType = $(Index.Ids.Player1Gesture);
		$subType.empty();
		$.each(list, function() {
			$subType.append($('<option></option>').val(this.name).text(this.name));
		});
	},
	
	formToJSON:function() {
		return 	'{"result":null,"winner":null,"player1":{"isHuman":'+Index.getIsHuman()+',"gesture":{"name":"'+Index.getSelectedGesture()+'"}},"player2":{"isHuman": false,"gesture": null}}';;
	},

	getIsHuman:function()
	{
		return $(Index.Ids.Player1Status).val() === "human";
	},

	getSelectedGesture:function() 
	{
		return $(Index.Ids.Player1Gesture).val();	
	},

	startNewGame:function() {
		$(Index.Ids.Outcome).hide();
	}		
};

Index.Ids = {
	PlayGame: '#play-game',
	Player1: 'input:radio[name=player1]',
	Player1Status: 'input:radio[name=player1]:checked',
	Player1Gesture: '#player1Gesture',
	Outcome: '#outcome',
	WinningCondition: '#winning-condition',
	ErrorMessage: '#error-message',
	WinningPlayer: '#winning-player'
};


$(document).ready(function() {
	Index.setup();
});
