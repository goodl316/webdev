<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<div>
		<form action="/user/join" method="post" onsubmit="return joinChk();">
		<div><input type="text" name="user_id" placeholder="id" required></div>
		<div><input type="password" name="user_pw" placeholder="password" required></div>
		<div><input type="password" name="user_pw_chk" placeholder="password_check"></div>
		<div><input type="text" name="nm" placeholder="Your name" required></div>
		<div>
			Gender :
			<label>Woman<input type="radio" name="gender" value="0" checked></label>
			<label>Man<input type="radio" name="gender" value="1"></label>
		</div>
		<div>
			<input type="text" name="ph" placeholder="Your Phone Number">
		</div>
		<div><input type="submit" value="JOIN"></div>		
		</form>
	</div>
</html>