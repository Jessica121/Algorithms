class PeekingIterator implements Iterator<Integer> {

    /*
    could use a temp, when want to peek(), call next, if has next put the item in the temp
    when want to call next, check temp is not null, if so nullify and return that.
    else check is hasnext, if so get next. else return false.
    has next should be if temp is not null or it has next.
    
    */
    
    Iterator<Integer> iter;
    Integer temp;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iter = iterator;
        temp = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(temp != null) return temp;
        temp = iter.next();
        return temp;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(temp != null) {
            Integer res = temp;
            temp = null;
            return res;
        }
        if(hasNext()) return iter.next();
        return null;
	}

	@Override
	public boolean hasNext() {
	    return temp != null || iter.hasNext();
	}
}