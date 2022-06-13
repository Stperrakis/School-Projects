%% Main 
%Declare Function
clc
clear
close all
syms x y

f(x,y) = 100*((y-x.^2)^2)+(1-x).^2;
start =[4,-8]

% f(x,y) = 5*x.^4+6*y.^4-6*x.^2+2*x*y+5*y.^2+15*x-7*y+13;
% start =[1,1]


%f(x,y) = x.^2+y.^2;
%start =[10,10]



f1 = figure;
[x,y] = meshgrid([-10:10],[-10:10]);
z=double(f(x,y));
surf(x,y,z)
sym x
hold on

start1= num2cell(start);
f(start1{:})
e = 0.00005;
disp('for General Newton')
localMin = GeneralNewton(f,start,e);

disp('for bfgs Newton')
localMin2 = BFGSquasi(f,start,e,f1);
localMin2