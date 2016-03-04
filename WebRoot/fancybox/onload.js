$(document).ready(function() {
        $("a[href$='.jpg'],a[href$='.jpeg'],a[href$='.png'],a[href$='.gif']").attr('rel', 'gallery').fancybox();
        $(".iframe").fancybox({
    		'width'				: '780px',
    		'height'			: '560px',
            'autoScale'     	: false,
            'transitionIn'		: 'none',
    		'transitionOut'		: 'none',
    		'type'				: 'iframe'
    	});
});