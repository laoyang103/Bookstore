$(function() {
	$("#pdate").glDatePicker({
		onChange: function(target, newDate)
	    {
	        target.val
	        (
	            newDate.getFullYear() + "-" +
	            (newDate.getMonth() + 1) + "-" +
	            newDate.getDate()
	        );
	    }
	});
	
	$("#edate").glDatePicker({
		onChange: function(target, newDate)
	    {
	        target.val
	        (
	            newDate.getFullYear() + "-" +
	            (newDate.getMonth() + 1) + "-" +
	            newDate.getDate()
	        );
	    }
	});
	
});