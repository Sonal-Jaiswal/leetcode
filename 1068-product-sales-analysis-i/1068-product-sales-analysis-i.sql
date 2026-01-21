SELECT 
    pt.product_name,
    st.year,
    st.price
FROM Product pt
JOIN Sales  st
ON pt.product_id = st.product_id
