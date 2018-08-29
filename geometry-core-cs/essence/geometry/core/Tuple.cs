namespace essence.geometry.core
{
    public interface Tuple
    {
        /**
         * This method gets the number of components of this tuple.
         *
         * @return Size of this tuple.
         */
        int Size { get; }

        /**
         * This method gets the values of this tuple into {@code tupleSet}.
         *
         * @param tupleSet Where to get the values.
         */
        void GetInto(TupleSet tupleSet);
    }
}
