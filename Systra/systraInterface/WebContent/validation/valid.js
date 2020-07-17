
/****************************VALIDATION MAILSENDER*************************/
		$.validator.setDefaults( {
			submitHandler: function () {
				$(form).ajaxSubmit();
			}
		} );
		

		/****************************VERIFICATION MESSAGE*************************/

		$( document ).ready( function () {
			$.validator.addMethod("valid", function(value, element) {
				if (this.optional(element)) {
					return true;
				}
			    return /^[a-zA-Z \s]+$/.test(value);
			}, "Charactere invalide");
			

			$( "#mailForm" ).validate( {
						 errorClass: "my-error-class",
						   validClass: "my-valid-class",
					
						rules: {
						
							mail:{
								required:true,
								email:true,
				                 },
							
							message:{
								required:true,
								minlength: 8,
				
							},
							nomComplet:{
								required:true,
								valid:true,
								minlength: 5,
												
							},
							
																		
						},
						messages: {
							mail:{
								required:"Entrer votre email",
								email:"Email incorrecte",
							},
							message:{
								required:"Ecrivez votre message",
								minlength:"Message trop court(Minimum 8 characteres)",
							},
							nomComplet:{
								
								required:"Entrer votre nom complet",
								valid:"charactere invalide",
								minlength:"Minimun 5 Characteres",
								
							},
							
						
						},
						errorElement: "em",
						errorPlacement: function ( error, element ) {
							// Add the `help-block` class to the error element
							error.addClass( "help-block" );

							// Add `has-feedback` class to the parent div.form-group
							// in order to add icons to inputs
							element.addClass( "has-feedback" );

							if ( element.prop( "type" ) === "checkbox" ) {
								error.insertAfter( element.parent( "label" ) );
							} else {
								error.insertAfter( element );
							}

						
						},
				
					
					} );
				} );

/****************************VERIFICATION USER*************************/

$( document ).ready( function () {
	$.validator.addMethod("valid", function(value, element) {
		if (this.optional(element)) {
			return true;
		}
	    return /^[a-zA-Z \s]+$/.test(value);
	}, "Charactere invalide");
	
	
/*	jQuery.validator.addMethod( 'passwordMatch', function(value, element) {
	    
	    // The two password inputs
	    var password = $("#newPassword").val();
	    var confirmPassword = $("#confirmPassword").val();

	    // Check for equality with the password inputs
	    if (password != confirmPassword ) {
	        return false;
	    } else {
	        return true;
	    }

	}, "Your Passwords Must Match");

	*/
/*	$.validator.addMethod('passwordMatch', function(value){
	    if(value == $('#newPassword').val()){
	        return true;
	     }
	     return false;
	}, "Password and confirm password fields do not match");
	
	*/
	$( "#userForm" ).validate( {
				 errorClass: "my-error-class",
				   validClass: "my-valid-class",
			
				rules: {
				
					oldPassword:{
						required:true,
		                 },
					
					newPassword:{
						required:true,
						minlength: 8,
		
					},
					confirmPassword:{
						required:true,
						/*equalTo:"#newPassword",*/
						minlength: 8,
						
		
					},
					
					userNom:{
						required:true,
						valid:true,
						minlength: 3
		
					},
					userPrenom: {
						required: true,
						valid:true,
						minlength: 3
					},
				
					userAdresse: {
						required: true,
						minlength: 5,
						
					},
					userEmail: {
						required: true,
						email: true
					},
					userTel: {
						required: true,
						minlength:8
					},
												
				},
				messages: {
					oldPassword:{
						required:"Entrer l'ancien mot de passe",
					},
					newPassword:{
						required:"Entrer le nouveau password",
						minlength:"Password trop court(Minimum 8 characteres)"
					},
					confirmPassword:{
						required:"Rettapez le nouveau mot de passe",
						minlength:"Password trop court(Minimum 8 characteres)",
						/*equalTo: "Your Passwords Must Match",*/
						
					},
					userNom:{
						
						required:"Entrer le nom",
						valid:"charactere invalide",
						minlength:"Minimun 3 Characteres",
						
					},
					userPrenom: {
						required:"Entrer le prenom",
						valid:"charactere invalide",
						minlength:"Minimun 3 Characteres"
					},
				
					userEmail: {
						required:"Entrer l'email",
						email:"Email invalide"
					},
					userAdresse: {
						required:"Entrer l'adresse",
						minlength:"Minimun 5 Characteres"
					},
					userTel: {
						required:"Entrer le Tel",
						minlength:"Minimun 8 Characteres"
					},
				
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.addClass( "has-feedback" );

					if ( element.prop( "type" ) === "text" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element ).css("color", "#FF0000");
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) ).css("color", "green");
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" ).css("color", "#FF0000");
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" ).css("color", "green");
				}
			} );
		} );
		
		
 /****************************VERIFICATION LOTS*************************/

$( document ).ready( function () {
	$.validator.addMethod("valid", function(value, element) {
		if (this.optional(element)) {
			return true;
		}
	    return /^[a-zA-Z \s]+$/.test(value);
	}, "Charactere invalide");
	
			$( "#info" ).validate( {
				 errorClass: "my-error-class",
				   validClass: "my-valid-class",
				rules: {					 
					noPlaque:{
						required:true,						
					},
					transpoteur: {
						required: true,
						valid:true
					},
					dateTransp: {
						required: true,
						minlength: 5
					},
				
					dateLivraison: {
						required: true,
						
					},
				},
				messages: {
					noPlaque: {
						required:"Entrer le numero de la plaque",
				
					},
					transpoteur:{
						required:"Entrer le transporteur",
					     valid:"charactere invalide"
					},
					dateTransp: {
						required:"Entrer la date du transport",
						
					},
					dateLivraison: {
						required:"Entrer la date de la livraison",
						
					},
				
					
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element ).css("color", "red");
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) ).css("color", "green");
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" ).css("color", "red");
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" ).css("color", "green");
				}
			} );
		} );

/****************************VERIFICATION ACHAT*************************/



$( document ).ready( function () {
	$( "#achatForm" ).validate( {
				 errorClass: "my-error-class",
				   validClass: "my-valid-class",
			
				rules: {
					achatQT:{
						required:true,
						digits:true
					},
					
					achatPT: {
						required: true,
						number:true
					},
					
					achatIDFour: {
						required: true
						
					},
				
					achatDate: {
						required: true
						
					},
				},
				messages: {
					achatProdID: {
						required:"Entrer l'ID du producteur",
				
					},
					achatQT:{
						required:"Entrer la quantite totale",
					digits:"incorrecte"
					},
					achatPT: {
						required:"Entrer le prix total",
						number:"Incorrecte"
					},
					achatIDFour: {
						required:"Entrer l'id du fournisseur"
						
					},
				
					achatDate: {
						required:"Entrer la date"
						
					},
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element ).css("color", "#FF0000");
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) ).css("color", "green");
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" ).css("color", "#FF0000");
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" ).css("color", "green");
				}
			} );
		} );
		

		
/****************************VERIFICATION PRODUCTEUR*************************/
		$.validator.setDefaults( {
			submitHandler: function () {
				form.submit();
			}
		} );
		

$( document ).ready( function () {
	$.validator.addMethod("valid", function(value, element) {
		if (this.optional(element)) {
			return true;
		}
	    return /^[a-zA-Z \s -]+$/.test(value);
	}, "Charactere invalide");
	
			$( "#prodForm" ).validate( {
				 errorClass: "my-error-class",
				   validClass: "my-valid-class",
			
				rules: {
					prodNomComplet:{
						required:true,
						valid:true,
						minlength: 3
										
					},
				
              		prodTel: {
						required: true,
						minlength:8
					},
					prodID: {
						required: true,
						
					},
				},
				messages: {
					
					prodNomComplet:{
						required:"Entrer le nom complet",
						minlength:"Minimun 3 Characteres"
						/*regex:"invalide"*/
					},
				
					prodTel: {
						required:"Entrer le Tel",
						minlength:"Minimun 8 Characteres"
					},
					prodID: {
						required:"Le code est necessaire",
						
					},
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element ).css("color", "#FF0000");
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) ).css("color", "green");
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" ).css("color", "#FF0000");
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" ).css("color", "green");
				}
			} );
		} );
		


		




/****************************VERIFICATION FOURNISSEUR*************************/

$( document ).ready( function () {
	$.validator.addMethod("valid", function(value, element) {
		if (this.optional(element)) {
			return true;
		}
	    return /^[a-zA-Z \s]+$/.test(value);
	}, "Charactere invalide");
	
	

	
	$( "#fournForm" ).validate( {
				 errorClass: "my-error-class",
				   validClass: "my-valid-class",
			
				rules: {
					fournID:{
						required:true,
						minlength: 3,
						
						
					}, 
					fournNom:{
						required:true,
						valid:true,
						minlength: 3
				},
					fournPrenom: {
						required: true,
						valid:true,
						minlength: 3
					},
					fournNif: {
						required: true,
						minlength: 5
					},
					fournAdresse: {
						required: true,
						minlength: 5,
						
					},
					fournEmail: {
						required: true,
						email: true
					},
					fournTel: {
						required: true,
						minlength:8
					},
							
				
					fournUsine: {
						required:true,
					
					},
				},
				messages: {
					fournID: {
						required:"Entrer l'ID",
		
						minlength:"Minimun 3 Characteres"
					},
					fournNom:{
						
						required:"Entrer le nom",
						minlength:"Minimun 3 Characteres",
						
					},
					fournPrenom: {
						required:"Entrer le prenom",
						minlength:"Minimun 3 Characteres"
					},
					fournNif: {
						required:"Entrer le nif",
						minlength:"Minimun 10 Characteres"
					},
					fournEmail: {
						required:"Entrer l'email",
						email:"Email invalide"
					},
					fournAdresse: {
						required:"Entrer l'adresse",
						minlength:"Minimun 5 Characteres"
					},
					fournTel: {
						required:"Entrer le Tel",
						minlength:"Minimun 8 Characteres"
					},
				
					
					fournUsine: {
						required:"Entrer l'usine",
					
					},
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element ).css("color", "#FF0000");
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) ).css("color", "green");
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" ).css("color", "#FF0000");
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" ).css("color", "green");
				}
			} );
		} );
		
		
		
/****************************VERIFICATION*************************/	
$( document ).ready( function () {
			
			$( "#Verif" ).validate( {
				 errorClass: "my-error-class",
				   validClass: "my-valid-class",
				rules: {
					prodID:{
						required:true,
						
					}, 
					fournID:{
						required:true,
						
					}, 
				
				},
				messages: {
					prodID: {
						required:"Entrer le code du producteur",
					
					},
					fournID: {
						required:"Entrer le code du fournisseur",
					
					},
					
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element ).css("color", "red");
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) ).css("color", "green");
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" ).css("color", "red");
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" ).css("color", "green");
				}
			
			} );
		} );
		
$("#testform").simpleform({
	speed : 500,
	transition : 'slide',
	progressBar : true,
	showProgressText : true,
	validate: true
});


function validateForm(formID, Obj){
Obj.validate({
	 errorClass: "my-error-class",
	   validClass: "my-valid-class",
				rules: {
					
					tel:{
						required:true,
						
					},
					codeMARNDR:{
						required:true,
						
					}, 
					commune:{
						required:true,
												
						
					},
					sectionCom: {
						required: true,
						
					},
					localite: {
						required: true,
						minlength: 3
					},
					superficie: {
						required: true,
						
						
					},
					lat1: {
						required: true,
						
					},
					lat2: {
						required: true,
						
					},
					lat3: {
						required: true,
						
					},
					lat4: {
						required: true,
						
					},
					
					long1: {
						required: true,
						
					},
					long2: {
						required: true,
						
					},
					long3: {
						required: true,
						
					},
					long4: {
						required: true,
						
					},
					
					agePlant: {
						required: true,
						
					},
					manguierSP: {
						required: true,
						
					},
					manguierEP: {
						required: true,
						
					},
					productionAn: {
						required: true,
						
					},
					nom:{
						required:true,
						valid:true,
						minlength:3,
						
					},
					prenom:{
						required:true,
						valid:true,
						minlength:3,
						
					},
		             email: {
						required: true,
						email: true
					},
					name: {
						required: true
					},
					street: {
						required: true
					}
				},
				messages: {
					tel: {
						required:"Entrer le telephone",					
					
					},
					
					codeMARNDR: {
						required:"Entrer le code codeMARNDR",					
						minlength:"L'ID doit contenir au moins 3 lettres"
					},
					commune:{
						required:"Choisir la commune",
						
					},
					sectionCom: {
						required:"Choisir la sectioncommunale",
					
					},
					localite: {
						required:"Entrer la localite",
						minlength: "La localite est trop courte"
					},
					superficie: {
						required:"Entrer la superficie",
						
					},
					lat1: {
						required:"Entrer la latitude1",
                       },
                       lat2: {
   						required:"Entrer la latitude2",
                          },
                          
                          lat3: {
      						required:"Entrer la latitude3",
                             },
                          
                             lat4: {
         						required:"Entrer la latitude4",
                                },
                                
                            	long1: {
            						required:"Entrer la longitude1",
                                   },
                                   long2: {
               						required:"Entrer la longitude2",
                                      },
                                      long2: {
                  						required:"Entrer la longitude2",
                                         },
                                         long3: {
                     						required:"Entrer la longitude3",
                                            },
                                            long4: {
                        						required:"Entrer la longitude4",
                                               },
                                
                                                 
                                               agePlant: {
						required:"Entrer l'age de la plantation",
					
					},
					
				manguierSP: {
						required:"Entrer le nombre de manguier SP"
					
					},
					
					manguierEP: {
						required:"le nombre de manguier EP",
					
					},
					
                    agePlant: {
						required:"Entrer l'age de la plantation",
					
					},
					
					productionAn: {
							required:"Entrer la production annuelle",
						
						},
					nom: {
						required:"Entrer le nom",					
						minlength:"Le nom doit contenir au moins 3 lettres"
					},
					prenom: {
						required:"Entrer le prenom",					
						minlength:"Le prenom doit contenir au moins 3 lettres"
					},
					email: {
						required: "Please enter an email address",
						email: "Not a valid email address"
					},
					name: {
					 	required: "Please enter your name"
					},
					street: {
						required: "Please enter street name"
					},
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element ).css("color", "red");
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) ).css("color", "green");
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" ).css("color", "red");
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" ).css("color", "green");
				}
			} );
				
			
		return Obj.valid();

}

