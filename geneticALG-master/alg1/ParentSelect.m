function [ p ] = ParentSelect( unqP, S )
%PARENTSELECT Summary of this function goes here
%   Detailed explanation goes here
% to be sure that the elite 1 is inside!
temp = 2;
p =S(1,:);
for i=2:unqP
 a = randi([temp,fix(unqP)]);
 p(i,:) = S(a,:);
 tempP = S(temp,:);
 S(temp,:)= S(a,:);
 S(a,:) = tempP;
 temp = temp+1;
end
end

