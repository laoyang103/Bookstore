$(document).ready(function() {
	//注册部分：
	$("#regUsernameInputBox").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '必填的哦' 
		}
	});
	$("#captchaInputBox").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '必填的哦' 
		}
	});
	$("#address1").inputNotes({
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '必填的哦' 
		}
	});
	
	
	
	$("#realname1").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '必填的哦' 
		}
	});
	
	$("#password1").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '必填的哦' 
		}
	});

	$("#postcode1").inputNotes({
		config : {
			notePosition : 'before'
		},
		warning : {
			pattern : /^[0-9]+$/,
			type : 'note',
			text : '只能输入数字 ...',
			inversedBehavior : true
		}
	});
	$("#telephone1").inputNotes({
		config : {
			notePosition : 'before'
		},
		warning : {
			pattern : /^[0-9]+$/,
			type : 'note',
			text : '只能输入数字 ...',
			inversedBehavior : true
		}
	});
});