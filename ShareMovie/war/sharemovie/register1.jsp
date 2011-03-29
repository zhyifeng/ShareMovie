<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
  <title> 
欢迎加入ShareMovie
</title> 
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Expires" content="Sun, 6 Mar 2005 01:00:00 GMT"> 
 
    
    <link rel="shortcut icon" href="http://img3.douban.com/favicon.ico" type="image/x-icon"> 
    <link href="http://img3.douban.com/css/packed_douban57.css" rel="stylesheet" type="text/css"> 
    <script type="text/javascript">var _head_start = new Date();</script> 
    <script type="text/javascript" src="http://img3.douban.com/js/packed_jquery.min4.js"></script> 
    <link href="http://img3.douban.com/css/separation/packed__all12.css" rel="stylesheet" type="text/css"> 
    <script type="text/javascript" src="http://img3.douban.com/js/packed_douban135.js"></script> 
    <script type="text/javascript" src="http://img3.douban.com/js/separation/packed__all8.js"></script> 
    
<script type="text/javascript" src="http://img3.douban.com/js/packed_do3.js" data-cfg-autoload="false"></script> 

   <style type="text/css">  
        .code   
        {   
            background-image:url(code.jpg);   
            font-family:Arial;   
            font-style:italic;   
            color:Red;   
            border:0;   
            padding:2px 3px;   
            letter-spacing:3px;   
            font-weight:bolder;   
        }   
        .unchanged   
        {   
            border:0;   
        }   
    </style>  
    <script language="javascript" type="text/javascript">  
       
     var code ; //在全局 定义验证码   
     function createCode()   
     {    
       code = "";   
       var codeLength = 6;//验证码的长度   
       var checkCode = document.getElementById("checkCode");   
       var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的   
           
       for(var i=0;i<codeLength;i++)   
       {   
         
           
       var charIndex = Math.floor(Math.random()*36);   
       code +=selectChar[charIndex];   
          
          
       }   
//       alert(code);   
       if(checkCode)   
       {   
         checkCode.className="code";   
         checkCode.value = code;   
       }   
          
     }   
        
      function validate ()   
     {   
       var inputCode = document.getElementById("input1").value;   
       if(inputCode.length <=0)   
       {   
           alert("请输入验证码！");   
       }   
       else if(inputCode != code )   
       {   
          alert("验证码输入错误！");   
          createCode();//刷新验证码   
       }   
       else   
       {   
         alert("^-^ OK");   
       }   
          
       }   
          
    </script>  
 
    <style type="text/css"> 
a { color: #336699 }
em { font-style: normal }
form { position: relative; left: 0; top: 0 }
.item { margin: 15px 0 }
.item-error { margin-left: 75px; color: #fe2617 }
.suggestion { padding-left: 75px }
label { display: inline-block; float:left; margin-right: 15px; text-align: right; width: 60px; font-size: 14px; line-height: 30px; vertical-align: middle }
.agreement-label { display: inline; width: auto; text-align: left; float: none }
.box { margin-left: 75px }
.basic-input { width: 200px; padding: 5px; height: 18px; font-size: 14px; -moz-border-radius: 3px; -webkit-border-radius: 3px; border-radius: 3px; border: 1px solid #c9c9c9 }
.item .basic-input:focus { border: 1px solid #a9a9a9 }
.validate-option { display: none; color: #808080 }
.validate-error { display: none; color: #fe2617 }
p.validate-error { margin-left: 75px }
.loc-item .validate-error { line-height: 30px }
.extra-tips .validate-error , .extra-tips .validate-option { padding-left: 10px; background: url(http://img3.douban.com/pics/icon/tips_arrow.gif) no-repeat}
.extra-tips .validate-error { background-position: left -51px }
.extra-tips .validate-option { background-position: left 5px }
.loc { font-size: 12px; line-height: 30px }
.tips , #location , .agreement-label { font-size: 12px; color: #808080 }
#location strong { color: #111111; font-weight: normal }
.captcha-item span.validate-error { padding-left: 10px; background: url(http://img3.douban.com/pics/icon/tips_arrow.gif) no-repeat left -51px ; display: none }
.captcha-img { margin: 2px 6px 0 0; vertical-align: top }
.captcha-item label { height: 90px }
.captcha-item .basic-input { width: 95px }
.captcha-item { zoom: 1 }
.agreement input , .agreement label { cursor: pointer }
.agreement-label { color: #000 }
#email_suggestion { display: inline-block; position: absolute; left: 75px; top: 30px; _left: 0px }
#email_suggestion p { background: #eef9eb; border: 1px solid #5e5e5f; margin: 0; padding: 3px }
.btn-submit { cursor: pointer; font-size: 14px; font-weight: bold; padding: 6px 26px; border-radius: 3px; -moz-border-radius: 3px; -webkit-border-radius: 3px; *width: 100px }
.disabled { color: #999; background: #f0f0f0; border: 1px solid #b9b9b9 }
.enabled { color: #ffffff; background: #3fa156; border: 1px solid #528641 }
 
/* for popwin */
.loading { font-size: 14px; margin: 12px; color: #888; background-position: left center; padding: 0 0 0 20px; float: none; width: auto; height: auto }
#l_tabs li { display: inline-block; padding: 0px 12px }
#l_tabs li { *display: inline }
.selected { background: #93b77b;  border-radius: 3px; -moz-border-radius: 3px; -webkit-border-radius: 3px; color: #ffffff }
.selected a { color: #fff!important }
.panel ul { border-top: 1px solid #cccccc; padding: 12px 0 0 12px; margin: 10px 0 }
.panel a { font-size: 14px }
.panel ul li { display: inline-block; padding: 0 3px ; margin-right: 15px }
.panel ul li { *display: inline }
.off { display: none }
.panel li.on , .panel li.off { margin-right: 8px }
.panel li.on a , .panel li.off a { font-size: 12px; line-height: 15px }
.expand , .contract { margin: 0; text-align: right; padding-right: 10px }
.panel .expand a , .panel .contract a { font-size: 12px }
.panel .expand { background: url(http://img3.douban.com/pics/icon/tongcheng_tab_down.gif) no-repeat right 2px }
.panel .contract { background: url(http://img3.douban.com/pics/icon/tongcheng_tab_up.gif) no-repeat right 2px }
</style> 
    <script type="text/javascript"> 
Do.add('dialog-css', {path: 'http://img3.douban.com/css/ui/packed_dialog1.css', type: 'css'});
Do.add('dialog', {path: 'http://img3.douban.com/js/ui/packed_dialog6.js', type: 'js', requires: ['dialog-css']});
Do.add('validate', {path: 'http://img3.douban.com/js/lib/packed_validate6.js', type: 'js'});
</script> 
</head> 
<body  onload="createCode()"> 
    <script type="text/javascript">var _body_start = new Date();</script> 
    
    <div class="top-nav-info"> 
</div> 
 
  </div> 
</div> 
 
    <div id="wrapper">  
        
    <div id="content"> 
    
    <h1>欢迎加入ShareMovie</h1> 
 
    <div class="grid-16-8 clearfix"> 
        
        <div class="article">
        <s:form action="registeract" namespace="/sharemovie" method="post" >
            <div class="item extra-tips"> 
                <s:textfield id="name" class="basic-input" label="username" cssClass="input_list" name="username" />
            </div> 
        </s:form>
    <s:form name="lzform" name="" method="post" action="register"> 
        <div class="item extra-tips"> 
            <label>邮箱</label> 
            <input id="email" name="form_email" type="email" class="basic-input" maxlength="60" tabindex="1" value=""/> 
        </div> 
        <div class="suggestion"> 
            <div id="email_suggestion"></div> 
        </div> 
        <div class="item extra-tips"> 
            <label>密码</label> 
            <input id="password" name="form_password" type="password" class="basic-input" tabindex="2" maxlength="20"/> 
        </div> 
        <div class="item extra-tips"> 
            <label>名号</label> 
            <input id="name" name="form_name" type="text"
            class="basic-input" maxlength="15" tabindex="3" value=""/> 
        </div>
        <div class="item captcha-item"> 
          <label>验证码</label>  
    <input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 80px"  /><br />
          <input  type="text"   id="input1" class="basic-input captcha" tabindex="4" maxlength="10"/>
          
          <input type="hidden" value="DCWyIwuykI4M9X5tttvuRtqU" name="captcha-id"> 
          <br />
            <input id="Button1"  onclick="validate();" type="button" value="确定" />
            <span class="validate-error" id="frm_error"></span> 
        </div>
        <div class="item-submit"> 
          <label>&nbsp;</label> 
            <input type="submit" value="注册" disabled="disabled" id="button" class="btn-submit disabled" tabindex="6" title="阅读并同意sharemovie的《使用协议》方可注册。"/> 
        </div> 
    </s:form> 
</div> 
        <div class="aside"> 
            
<p class="pl">&gt; 已经拥有sharemovie帐号? <a rel="nofollow" href="/accounts/login">直接登录</a></p> 
 
 
        </div> 
        <div class="extra"> 
            
        </div> 
    </div> 
    </div> 
 
        
    <div id="footer"> 
        
 
<span id="icp" class="fleft gray-link"> 
    &copy; 2011 sharemovie.com, all rights reserved
</span> 
 
<span class="fright"> 
    <a href="http://www.douban.com/about">关于ShareMovie</a>  
    · <a href="http://www.douban.com/about?topic=contactus">联系我们</a> 
    · <a href="http://www.douban.com/about?policy=disclaimer">免责声明</a> 
 
</span> 
 
 
    </div> 
 
    </div> 
    
<script> 
Do('validate','dialog',function(){
    var email = $('#email'),
        suggestion = $('#email_suggestion'),
        email_value = '',
        e_name = '',
        e_domain = '',
        e_tip_on = 0,
        passwd_reg = /^[\u4e00-\u9fa5]/,
 
        email_list = new Array('163.com','126.com', '139.com', '188.com', '2008.china.com', '2008.sina.com', '21cn.com', '263.net', 'china.com', 'chinaren.com', 'citiz.net', 'eyou.com', 'foxmail.com', 'gmail.com', 'hongkong.com', 'hotmail.com', 'live.cn', 'live.com', 'mail.china.com', 'msn.com', 'my3ia.sina.com', 'qq.com', 'sina.cn', 'sina.com', 'sina.com.cn', 'sogou.com', 'sohu.com', 'vip.163.com', 'vip.qq.com', 'vip.sina.com', 'vip.sohu.com', 'vip.tom.com', 'yahoo.cn', 'yahoo.com', 'yahoo.com.cn', 'yahoo.com.hk', 'yahoo.com.tw', 'yeah.net'),
 
        TXT_CAPTCHA_NULL = '请输入验证码',
        TXT_CAPTCHA_ERROR = '请输入正确的验证码',
        error_info = $('#frm_error').text();
 
        if ( error_info === TXT_CAPTCHA_NULL || error_info === TXT_CAPTCHA_ERROR ) {
            $('#frm_error').show();
        } else {
            $('<div></div>').text(error_info).addClass('item-error').insertAfter('.captcha-item').show();
            $('#frm_error').remove();
        }
 
    function DPA(s1, s2){
        var m = new Array();
        var i, j;
        for(i=0; i < s1.length + 1; i++) m[i] = new Array(); // i.e. 2-D array
 
        m[0][0] = 0; // boundary conditions
 
        for(j=1; j <= s2.length; j++)
            m[0][j] = m[0][j-1]-0 + 1; // boundary conditions
 
        for(i=1; i <= s1.length; i++)                            // outer loop
        {
            m[i][0] = m[i-1][0]-0 + 1; // boundary conditions
 
            for(j=1; j <= s2.length; j++)                         // inner loop
            {
                var diag = m[i-1][j-1];
                if( s1.charAt(i-1) != s2.charAt(j-1) ) diag++;
 
                m[i][j] = Math.min( diag,               // match or change
                Math.min( m[i-1][j]-0 + 1,    // deletion
                m[i][j-1]-0 + 1 ) ); // insertion
            }//for j
        }//for i
       return m[s1.length][s2.length];
    };
 
    function get_like(s){
        r = 0;
        v = s.split('@');
        if ( v.length <=1 ) return;
        domain = v[1];
        e_name = v[0];
        dis = domain.length;
        for (k=0; k < email_list.length; k++){

            e = email_list[k];
            d = DPA(domain, e);
            if (d < dis){
                dis = d;
                e_domain = e;
            }
        }
        if(dis && dis < 4){
            r = 1;
        }
        return r;
    };
 
    function email_suggestion(like){
        s = email.attr('value');
        if (!( s && s.length > 2 )) { 
            return;
        }
        if (like && get_like(s)){
            as = ' <a id="yes_but" href="#">是</a>／<a href="#" id="no_but">不是</a>';
            suggestion.html( '<p><span>你是否要输入' + e_name + '@</span>' + e_domain + as + '</p>' );
            $("#yes_but").focus();
            e_tip_on = 1;
        }
 
        email_value = email.attr('value');
        return r;
    };
 
    $('#email').focusout(function() {
        var e = $(this).parents('.item').hasClass('has-error');
        if ( !e ) {
            email_suggestion(1);
        }
    });
 
    $('body').delegate('#yes_but', 'click', function(e) {
        e.preventDefault();
        email.attr('value', e_name + '@' + e_domain);
        email.focus();
        suggestion.html( '' );
        e_tip_on = 0;
    });
    $('body').delegate('#no_but', 'click', function(e) {
        e.preventDefault();
        suggestion.html( '' );
        e_tip_on = 0;
    });
    $("input[name='form_agreement']").each(function(){
        if ($("input[name='form_agreement']").is(':checked')) {
            $("input[type='submit']").attr('disabled', false).addClass('enabled');
        } else {
            $("input[type='submit']").attr('disabled', true).removeClass('enabled');
        }
    });
    $("input[name='form_agreement']").click(function(){
        if ($("input[name='form_agreement']").is(':checked')) {
            $("input[type='submit']").attr('disabled', false).addClass('enabled');
        } else {
            $("input[type='submit']").attr('disabled', true).removeClass('enabled');
        }
 
    });
    var optionMsg = {
        form_email: '用来登录sharemovie，接收到激活邮件才能完成注册',
        form_password: '字母、数字或符号，最短4个字符，区分大小写',
        form_name: '中、英文均可，最长14个英文或7个汉字',
        loc: ''
    },
    validateError = {
        email: {
            isNull: 'Email不能为空',
            invalidFormat: 'Email格式不正确',
            unavailable: '',
            unableForTom: '目前暂时不支持使用 tom.com 邮箱注册sharemovie帐号',
            unableForChongseo: '目前暂时不支持使用 chongseo.cn 邮箱注册sharemovie帐号'
        },
        password: {
            isNull: '密码不能为空',
            isShort: '密码长度不足4个字符',
            invalidFormat: '请使用英文字母、符号或数字'
        },
        location: {
            isNull: '常居地不能为空'
        },
        name: {
            isNull: '名号不能为空',
            isLong: '名号长度不能超过14个英文或7个汉字'
        },
        captcha: {
            isNull: '验证码不能为空'
        }
    },
    validateRules = {
        email: {
            elems: 'input[name=form_email]',
            isNull: function(el) {
                return !$.trim(el.val());
            },
            invalidFormat: function(el) {
                  return !$.validate.isEmail($.trim(el.val()));
            },
            unavailable: function(el,o) {
                var item = el.parents('.item');
                if (item.hasClass('has-process')) return;
                item.addClass('has-process');
                s = $.trim(el.val());
                var url = '/j/register/is_registered?email='+s;
                $.getJSON(url, function(j){
                    if (j.ok){
                        el.val(s);
                        o.displayError(el, '该Email已经注册过');
                        item.addClass('has-error');
                    }
                    item.removeClass('has-process');
                });
            },
            unableForTom: function(el,o) {
                var domain = el.val().split('@')[1];
                return domain == 'tom.com';
            },
            unableForChongseo: function(el,o) {
                var domain = el.val().split('@')[1];
                return domain == 'chongseo.cn';
            }
 
        },
        password: {
            elems: 'input[name=form_password]',
            isNull: function(el) {
                if ( el.val() === '' ) return true;
            },
            isShort: function(el) {
                if ( el.val() !='' && el.val().length < 4 ) {
                    return true;
                }
            },
            invalidFormat: function(el) {
                var s = $.trim(el.val());
                return passwd_reg.test(s);
            }
        },
        name: {
            elems: 'input[name=form_name]',
            isNull: function(el) {
                return !$.trim(el.val());
            },
            isLong: function(el) {
                return $.trim(el.val()).replace(/[^\x00-\xff]/g, 'sharemovie').length <= 14 ? false : true;
            }
        },
        location: {
            elems: 'input[name=loc]',
            isNull: function(el) {
                return !$.trim(el.val());
            }
        },
        captcha: {
            elems: 'input[name=captcha-solution]',
            isNull: function(el) {
                return !$.trim(el.val());
            }
 
        }
    };
    $('form').validateForm(validateRules, validateError, optionMsg, null);
 
    $('#cap_resend').click(function(e){
        e.preventDefault();
        resendCaptcha();
    });
 
    function resendCaptcha(){
        var cap_img = $('.captcha-img');
        var cap_input = $("input[name='captcha-id']");
        var url = '/j/misc/captcha';
        $.getJSON(url, function(j){
            cap_img.attr('src',j.url);
            cap_input.val(j.token);
        });
    }
 
    $('body').delegate('p.expand a', 'click', function(e){
        e.preventDefault();
        $('li.off').show().addClass('on').removeClass('off');
        $(this).text('收起').parent().removeClass('expand').addClass('contract');
        dlg.updateSize();
          dlg.updatePosition();
 
    });
 
    $('body').delegate('p.contract a', 'click', function(e){
        e.preventDefault();
        $('li.on').hide().addClass('off').removeClass('on');
        $(this).text('更多').parent().removeClass('contract').addClass('expand');
        dlg.updateSize();
          dlg.updatePosition();
 
    });
 
    $('.a-btn-location').click(function(e) {
        e.preventDefault();
        $('.loading').hide();
        dlg.open();
        dlg.updateSize();
        dlg.updatePosition();
    });
 
});
</script> 
 
    
    
<script type="text/javascript"> 
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-7019765-1']);
_gaq.push(['_addOrganic', 'baidu', 'word']);
_gaq.push(['_addOrganic', 'soso', 'w']);
_gaq.push(['_addOrganic', '3721', 'name']);
_gaq.push(['_addOrganic', 'yodao', 'q']);
_gaq.push(['_addOrganic', 'vnet', 'kw']);
_gaq.push(['_addOrganic', 'sogou', 'query']);
_gaq.push(['_addIgnoredOrganic', 'sharemovie']);
_gaq.push(['_addIgnoredOrganic', 'douban']);
_gaq.push(['_addIgnoredOrganic', 'sharemovie网']);
_gaq.push(['_addIgnoredOrganic', 'www.douban.com']);
_gaq.push(['_setDomainName', '.douban.com']);
 
_gaq.push(['_trackPageview']);
 
 
(function() {
    var ga = document.createElement('script');
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    ga.setAttribute('async', 'true');
    document.documentElement.firstChild.appendChild(ga);
})();
</script> 
 
 
 
 
 
 
 
    <!-- ori--> 
</body> 
</html>