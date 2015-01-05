$(document).ready(function(){
	$("#form").validate({
		rules : {
			name : {required : true, lettersonly: true, rangelength: [3, 15]},
			// surname: {required: true, rangelength: [3, 20]},
			pass : {required: true, minlength: 5},
			email : {required: true, email: true},
			// passVerify : {required: true, minlength: 5}
			// phone: {rangelength: [7, 15] ,digitssonly: true }
		},
		messages : {
			name : {
				required : "Enter your name",
				rangelength : "Number of letters must be in range [3,15]",
				niqueUserName: "This login already used",
				lettersonly: "Unsupported format of name"
			},
			// surname : {
			// 	required : "Enter your surname",
			// 	rangelength: "Number of letters must be in range [3,20]"
			// }, 
			// phone : {
			// 	digitssonly: "Mustn't be only digits",
			// 	rangelength: "Number of letters must be in range [7,15]"

			// },
			email : {
				required: "Enter your current email adress",
				email: "Unsupported email adress"
			},
			pass : {
				required: "Enter password",
				minlength: "Password must include minimun 5 letters",
			},
			// checkbox : {
			// 	required: "Accept our rules."
			// }
		},
	});
});
jQuery.validator.addMethod("lettersonly", function(value, element) {
  return this.optional(element) || /^[a-z]+$/i.test(value);
}, "Letters only please");
function changeStatus(){
	if(form.checkbox.checked) form.registr.disabled = false;
	else form.registr.disabled = true;
}
jQuery.validator.addMethod("digitssonly", function(value, element) {
  return this.optional(element) || /^\+?[0-9\-\(\)\s]+$/i.test(value);
}, "Letters only please");