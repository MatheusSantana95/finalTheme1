@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  tema-1 startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and TEMA_1_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\tema-1.jar;%APP_HOME%\lib\spring-context-5.2.9.RELEASE.jar;%APP_HOME%\lib\spring-web-5.2.9.RELEASE.jar;%APP_HOME%\lib\spring-aop-5.2.9.RELEASE.jar;%APP_HOME%\lib\spring-beans-5.2.9.RELEASE.jar;%APP_HOME%\lib\spring-test-5.2.9.RELEASE.jar;%APP_HOME%\lib\spring-expression-5.2.9.RELEASE.jar;%APP_HOME%\lib\spring-core-5.2.9.RELEASE.jar;%APP_HOME%\lib\karyon2-governator-2.9.2.jar;%APP_HOME%\lib\karyon2-core-2.9.2.jar;%APP_HOME%\lib\javax.ws.rs-api-2.1.1.jar;%APP_HOME%\lib\rxnetty-contexts-0.4.7.jar;%APP_HOME%\lib\rxnetty-0.5.1.jar;%APP_HOME%\lib\rxjava-1.3.8.jar;%APP_HOME%\lib\netty-codec-http-4.1.53.Final.jar;%APP_HOME%\lib\slf4j-simple-1.7.0.jar;%APP_HOME%\lib\spring-jcl-5.2.9.RELEASE.jar;%APP_HOME%\lib\governator-1.14.2.jar;%APP_HOME%\lib\governator-core-1.14.2.jar;%APP_HOME%\lib\hibernate-validator-4.1.0.Final.jar;%APP_HOME%\lib\slf4j-api-1.7.6.jar;%APP_HOME%\lib\netty-handler-4.1.53.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.0.Beta7.jar;%APP_HOME%\lib\netty-codec-4.1.53.Final.jar;%APP_HOME%\lib\netty-transport-4.1.53.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.53.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.53.Final.jar;%APP_HOME%\lib\netty-common-4.1.53.Final.jar;%APP_HOME%\lib\governator-api-1.14.2.jar;%APP_HOME%\lib\asm-5.0.4.jar;%APP_HOME%\lib\jackson-databind-2.4.3.jar;%APP_HOME%\lib\guice-grapher-4.1.0.jar;%APP_HOME%\lib\guice-multibindings-4.1.0.jar;%APP_HOME%\lib\guice-assistedinject-4.1.0.jar;%APP_HOME%\lib\guice-4.1.0.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\validation-api-1.0.0.GA.jar;%APP_HOME%\lib\jackson-annotations-2.4.0.jar;%APP_HOME%\lib\jackson-core-2.4.3.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\guava-19.0.jar


@rem Execute tema-1
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %TEMA_1_OPTS%  -classpath "%CLASSPATH%" com.matheussantana.cloudnative.tema1.MainServer %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable TEMA_1_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%TEMA_1_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
