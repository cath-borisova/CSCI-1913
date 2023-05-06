#Katya Borisova
#boris 040
#lab partner: Michael Fisher
#fishe816
def left(e):
 return e[0]


def op(e):
 return e[1]


def right(e):
 return e[2]

def isInside(v,e):
 if type(e) == tuple:
  return isInside(v, left(e)) or isInside(v, right(e))
 else:
  return v == e

def solve(v, q):
	if isInside(v, q):
		if isInside(v, left(q)):
			return solving(v, q)
		elif isInside(v, right(q)):
			return solving(v, (right(q), op(q), left(q)))
	raise ValueError


def solving(v, q):
	opToEvaluator = {'+':solvingAdd,'-':solvingSubtract, '*':solvingMultiply, '/':solvingDivide}
	#print(op(left(q)))
	if v == left(q):
		return q
	elif op(left(q)) in opToEvaluator:
		#print("true")
		return opToEvaluator[op(left(q))](v, q)
	raise ValueError

def solvingAdd(v, q):
	if isInside(v, left(left(q))):
		return solving(v, (left(left(q)), op(q), (right(q), '-', right(left(q)))))
	else:
		return solving(v, (right(left(q)), op(q), (right(q), '-', left(left(q)))))

def solvingSubtract(v, q):
	if isInside(v, left(left(q))):
		return solving(v, (left(left(q)), op(q), (right(q), '+', right(left(q)))))
	else:
		return solving(v, (right(left(q)), op(q), (left(left(q)), '-', right(q))))

def solvingMultiply(v, q):
	if isInside(v, left(left(q))):
		return solving(v, (left(left(q)), op(q), (right(q), '/', right(left(q)))))
	else:
		return solving(v, (right(left(q)), op(q), (right(q), '/', left(left(q)))))

def solvingDivide(v, q):
	if isInside(v, left(left(q))):
		return solving(v, (left(left(q)), op(q), (right(q), '*', right(left(q)))))
	else:
		return solving(v, (right(left(q)), op(q), (left(left(q)), '/', right(q))))

print(isInside('x', 'x'))#  True   1 point
print(isInside('x', 'y'))#  False  1 point
print(isInside('x', ('x', '+', 'y')))#  True   2 points
print(isInside('x', ('a', '+', 'b')))#  False  2 points
print(isInside('+', ('a', '+', 'b')))#  False  2 points
print(isInside('x', (('m', '*', 'x'), '+', 'b')))#  True   2 points
print(solve('x', (('a', '+', 'x'), '=', 'c')))#  ('x', '=', ('c', '-', 'a'))  2 points
print(solve('x', (('x', '+', 'b'), '=', 'c')))#  ('x', '=', ('c', '-', 'b'))  2 points
print(solve('x', (('a', '-', 'x'), '=', 'c')))#  ('x', '=', ('a', '-', 'c'))  2 points
print(solve('x', (('x', '-', 'b'), '=', 'c')))#  ('x', '=', ('c', '+', 'b'))  2 points
print(solve('x', (('a', '*', 'x'), '=', 'c')))#  ('x', '=', ('c', '/', 'a'))  2 points
print(solve('x', (('x', '*', 'b'), '=', 'c')))#  ('x', '=', ('c', '/', 'b'))  2 points
print(solve('x', (('a', '/', 'x'), '=', 'c')))#  ('x', '=', ('a', '/', 'c'))  2 points
print(solve('x', (('x', '/', 'b'), '=', 'c')))#  ('x', '=', ('c', '*', 'b'))  2 points
print(solve('y', ('y', '=', (('m', '*', 'x'), '+', 'b'))))# ('y', '=', (('m', '*', 'x'), '+', 'b'))  2 points
print(solve('x', ('y', '=', (('m', '*', 'x'), '+', 'b'))))# ('x', '=', (('y', '-', 'b'), '/', 'm'))  2 points
print(solve('a', (('b', '+', 'c'), '=', ('d', '*', (('a', '/', 'e'), '-', 'f')))))# ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))  5 points
