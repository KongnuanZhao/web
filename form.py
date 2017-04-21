# -*- coding: utf-8 -*-
from django import forms
from zctj.models import HostList, NetworkAsset, IdcAsset

class HostsListForm(forms.ModelForm):
    class Meta:
        model = HostList
        fields = "__all__"
        widgets = {
          'ipw': forms.TextInput(attrs={'class': 'form-control'}),
          'ipn': forms.TextInput(attrs={'class': 'form-control'}),
          'hostname': forms.TextInput(attrs={'class': 'form-control'}),
          'product': forms.TextInput(attrs={'class': 'form-control'}),
          'application': forms.TextInput(attrs={'class': 'form-control'}),
          'servernum': forms.TextInput(attrs={'class': 'form-control'}),
          'cpu_groups': forms.TextInput(attrs={'class': 'form-control'}),
          'mem': forms.TextInput(attrs={'class': 'form-control'}),
          'disk': forms.TextInput(attrs={'class': 'form-control'}),
          'port_jg': forms.TextInput(attrs={'class': 'form-control'}),
          'status': forms.TextInput(attrs={'class': 'form-control'}),
          'remark': forms.TextInput(attrs={'class': 'form-control'}),
        }
