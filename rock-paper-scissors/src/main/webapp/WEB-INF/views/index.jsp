<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<header>
		<hgroup>
			<h1>Rock Paper Scissors</h1>
			<h2>How to spend an hour of my day having fun</h2>
		</hgroup>
	</header>
	<section id="setup">
		<form id="game" method="post">
			<fieldset style="width:400px">
				<legend>Player 1</legend>
				<p>Do you want to be Player One?<p>				
				Yes:<input id="player1-human" type="radio" name="player1" value="human" checked> No:<input id="player1-computer" type="radio" name="player1" value="computer"><br/><br/>
				<select id="player1Gesture"></select>				
				<input type="button" id="play-game" value="Play!">
			</fieldset>
		</form>
	</section>
	<section id="outcome">
		<p id="winning-player"></p>
		<p id="winning-condition"/>
		<p id="error-message"/>
	</section>
	<script
		src="<c:url value="/resources/scripts/lib/jquery-1.7.1.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/scripts/index.js"/>" type="text/javascript"></script>
</body>
</html>
