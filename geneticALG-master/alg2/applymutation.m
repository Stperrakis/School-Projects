function [ child1 child2 ] = applymutation( x,y,nvar,Pm )
%APPLYMUTATION Summary of this function goes here
%   Detailed explanation goes here
a = calcBinary( x );
b = calcBinary( y );


Pm = 1-Pm;

h =1 ;
cut = fix(size(a,2)/2);

child1 = [a(:,1:2),b(:,3:12),a(:,13:length(a))];
child2 = [b(:,1:2),a(:,3:12),b(:,13:length(a))];

i = randi([1 length(a)]);
Pcm = rand(1);
if Pcm>=Pm
    child1(:,i) = ~child1(:,i);
    child2(:,i) = ~child2(:,2);
end
[child1 child2]=calcDecimal(child1,child2);
end

