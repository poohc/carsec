/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';

	config.extraPlugins = 'uploadimage';
	
	config.toolbar_Provider =
		[
		 { name: 'document', items : [ 'Templates','-', 'Cut','Copy','Paste','-','Undo'] },
		 { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' , '-', 'NumberedList','BulletedList','Link','Unlink' ] },
		 { name: 'paragraph', items : ['Outdent','Indent', '-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
		 { name: 'insert', items : [ 'Image', 'Table','HorizontalRule','Smiley','SpecialChar', 'TextColor','BGColor'] },'/',
         { name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] }

        ];
	config.filebrowserImageUploadUrl=  '/media/bbs/ckeditorUpload.do';
	config.toolbar = 'Provider';
	config.uploadUrl = '/media/bbs/ckeditorUploader.do';


	config.toolbar_Basic =
	[
		['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink','-','About']
	];

};


CKEDITOR.on('dialogDefinition', function (ev) {
    var dialogName = ev.data.name;
    var dialog = ev.data.definition.dialog;
    var dialogDefinition = ev.data.definition;
    if (dialogName == 'image') {
        dialog.on('show', function (obj) {
            this.selectPage('Upload'); //업로드텝으로 시작
        });
        dialogDefinition.removeContents('advanced'); // 자세히탭 제거
        dialogDefinition.removeContents('Link'); // 링크탭 제거
    }
});