function [ out ] = mutation( fitness_values,Pm,state,nvar )
%MUTATION Summary of this function goes here
%   Detailed explanation goes here
num=fix(size(fitness_values,1)*Pm);

if mod(num,2)
    num = num-1;
end
if num<=1
    out = 0;
end
n = size(fitness_values,1);
l = num;
unique_Parrents = randperm(n,l);

for i = 1:2:num
    a = unique_Parrents(i);
    b = unique_Parrents(i+1);
    [child1,child2] = applymutation(fitness_values(a,1:nvar),fitness_values(a,1:nvar),nvar,Pm);
    out(i,:) = child1;
    out(i+1,:) = child2;    
end
end

