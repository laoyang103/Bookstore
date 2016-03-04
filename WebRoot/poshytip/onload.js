$(document).ready(function() {
	$("input[type='text'],textarea").poshytip({
		className : 'tip-twitter',
		showTimeout : 1,
		alignTo : 'target',
		alignX : 'center',
		offsetY : 5,
		allowTipHover : true,
		fade : true,
		slide : true
	});
});